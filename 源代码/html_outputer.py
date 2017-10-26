#encoding:utf8
class HtmlOutputer(object):
    def __init__(self):
        self.datas = []

    def collect_data(self,data):
        if data is None:
            return
        self.datas.append(data)

    def output_html(self):
        fout = open("./output/output.html","w")
        fout.writelines(["<html>\n", "<head>\n"])
        fout.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />")
        fout.writelines("<link rel=\"stylesheet\" type=\"text/css\" href=\"./style.css\" />\n")
        fout.writelines(["</head>\n", "<body class=\"g-wrap\">\n"])
       
        for data in self.datas:
            fout.writelines("<div class=\"g-info\">\n")
            fout.writelines(
                "<p class=\"m-tt\"><a target=\"_blank\" href=\"%s\">%s</a></p>\n" % (data["url"].encode("utf-8"), data["title"].encode("utf-8")))
            fout.writelines(["<p class=\"summary\">%s</p>\n"%data["summary"].encode("utf-8")])
        fout.writelines(["</body>\n", "</html>"])
        fout.close()
