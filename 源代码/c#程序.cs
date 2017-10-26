using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO.Ports;
using System.Threading;

namespace WindowsFormsApplication1
{
    public partial class frmMain :
      Form
    {
        int FlashTimes;
        int FlashCounts;
        Label FlashingLED;
        string TextRead;
        public frmMain()
        {
            InitializeComponent();
        }
        private int FillSerialPorts()
        {
            int PortCount;
            PortCount = 0;
            //加载串口列表
            SerialPort _tempPort;
            String[] Portname = SerialPort.GetPortNames();
            foreach (string str in Portname)
            {
                try
                {
                    _tempPort = new SerialPort(str);
                    _tempPort.Open();
                    if (_tempPort.IsOpen)
                    {
                        cboCOMPorts.Items.Add(str);
                        _tempPort.Close();
                        PortCount++;
                    }
                }
                catch (Exception ex)
                {
                    tsMessage.Text = ex.ToString();
                }
            }
            if (!(PortCount == 0))
                cboCOMPorts.SelectedIndex = 0;
            tsCOMPort.Text = cboCOMPorts.Text;
            return PortCount;
        }
        private void trkPWM_ValueChanged(object sender, EventArgs e)
        {
            lblPWM.Text = trkPWM.Value.ToString();
        }
        private void button1_Click(object sender, EventArgs e)
        {
            txtRead.Clear();
            if (cboCOMPorts.Text == "")
            {
                tsMessage.Text = "尚未选择串口！";
            }
            else
            {
                if (!serialPort1.IsOpen)
                {
                    serialPort1.PortName = cboCOMPorts.Text;
                    serialPort1.Open();
                    try
                    {
                        tsCOMPort.Text = cboCOMPorts.Text;
                        tsCOMState.Text = "开启";
                    }
                    catch (Exception ex)
                    {
                        tsMessage.Text = ex.ToString(); // "串口打开过程中遇到错误，串口不存在或者已经被占用！";
                        tsCOMPort.Text = "";
                        tsCOMState.Text = "已断开";
                    }
                }
                if (serialPort1.IsOpen)
                {
                    if (rbFading.Checked)
                    {
                        serialPort1.Write("F");
                        byte[] bytesToSend = new byte[1];
                        bytesToSend[0] = Convert.ToByte(trkPWM.Value * 2.55); //疑问：当Value=100，ToByte=255，但是((int)(trkPWM.Value * 2.55)).ToString()却是254？
                        serialPort1.Write(bytesToSend, 0, 1);

                        //serialPort1.Write( ((Char ) ((int) trkPWM.Value *2.55 )).ToString () ); //这个方法不能传递高于127的数
                        //tsMessage.Text = ((int)(trkPWM.Value * 2.55)).ToString();
                    }
                    else
                    {
                        serialPort1.Write("B");
                        serialPort1.Write(Convert.ToChar(Convert.ToInt16(trkPWM.Value)).ToString());
                    }
                    FlashLED(lblRX, 10);
                }
            }
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            FillSerialPorts();
            trkPWM.Value = 80;
        }
        private void FlashLED(Label LED, int Count)
        {
            FlashingLED = LED;
            FlashCounts = Count;
            timer1.Enabled = true;
        }
        private void DisplayText(object sender, EventArgs e)
        {
            txtRead.AppendText(TextRead);
        }
        private void serialPort1_DataReceived(object sender, SerialDataReceivedEventArgs e)
        {
            if (chkReceive.Checked)
            {
                TextRead = serialPort1.ReadExisting();
                this.Invoke(new EventHandler(DisplayText));
                FlashLED(lblRX, 10);
            }
        }
        private void timer1_Tick(object sender, EventArgs e)
        {
            //add flash times
            if (FlashTimes <= FlashCounts)
            {
                FlashingLED.Visible = !FlashingLED.Visible;
                FlashTimes++;
            }
            else
            {
                timer1.Enabled = false;
                FlashCounts = 0;
                FlashTimes = 0;
                FlashingLED.Visible = true;
            }
        }

        private void frmMain_Activated(object sender, EventArgs e)
        {
            if (cboCOMPorts.Items.Count == 0)
                FillSerialPorts();
        }
        private void button2_Click(object sender, EventArgs e)
        {
            serialPort1.Close();
            timer1.Enabled = false;
        }
        private void pictureBox1_Paint(object sender, PaintEventArgs e)
        {
            pictureBox1.Invalidate();
            int yOffset = 100;
            int yBase = 40;
            int xOffset = 40;
            int i;
            int x = 0;
            Pen p = new Pen(Color.Yellow, 1);
            Graphics g = e.Graphics;
            if (trkPWM.Value == 100)
                g.DrawLine(p, pictureBox1.Left, pictureBox1.Height - yOffset, pictureBox1.Left + 10, pictureBox1.Height - yOffset); // __
            else
                g.DrawLine(p, pictureBox1.Left, pictureBox1.Height - yBase, pictureBox1.Left + 10, pictureBox1.Height - yBase); // __
            for (i = 0; i <= 5; i++)
            {
                x = 100 * i;
                if (!((trkPWM.Value == 0) || (trkPWM.Value == 100)))
                    g.DrawLine(p, pictureBox1.Left + 10 + x, pictureBox1.Height - yBase, pictureBox1.Left + 10 + x, pictureBox1.Height - yOffset); // |
                                                                                                                                                   //p.Color = Color.Blue ;
                xOffset = trkPWM.Value;
                g.DrawLine(p, pictureBox1.Left + 10 + x, pictureBox1.Height - yOffset, pictureBox1.Left + 10 + xOffset + x, pictureBox1.Height - yOffset);//--
                if (!((trkPWM.Value == 0) || (trkPWM.Value == 100)))
                    g.DrawLine(p, pictureBox1.Left + 10 + xOffset + x, pictureBox1.Height - yOffset, pictureBox1.Left + 10 + xOffset + x, pictureBox1.Height - yBase);//|
                g.DrawLine(p, pictureBox1.Left + 10 + xOffset + x, pictureBox1.Height - yBase, pictureBox1.Left + 10 + xOffset + x + 100 - trkPWM.Value, pictureBox1.Height - yBase);//__
                e.Graphics.DrawString(trkPWM.Value.ToString() + "%", panel1.Font, new SolidBrush(Color.White), panel1.Left + 120, 5, StringFormat.GenericDefault);
            }
        }
        private void frmMain_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (serialPort1.IsOpen)
                serialPort1.Close();
        }
        private void 清空ToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            txtRead.Clear();
        }
    }
}
