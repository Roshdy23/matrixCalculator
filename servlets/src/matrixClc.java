import  java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class matrixClc extends  HttpServlet {

    public String get_matrix(String matrix, int sq)
    {
        String original="";
        for(int i=0;i<sq;i++)
        {
            for(int j=0;j<sq;j++)
            {
                original=original + " " +matrix.charAt(i*sq+j);
            }
            original=original +"<br>";
        }
        return original;
    }

    public String transpose(String matrix,int sq ,int n)
    {
        String trans="";
        for(int i=0;i<sq;i++)
        {
            for(int j=i;j<n;j+=sq)
            {
                trans=trans + " "+matrix.charAt(j);
            }
            trans=trans+"<br>";
        }
        return trans;
    }

    public String isidentity(String matrix, int sq ,int n)
    {
        int flag=0;
        int start=0;
        for(int i=0;i<n;i++)
        {
            if(i==start)
            {
                if(matrix.charAt(i)!='1')flag=-1;
                start+=sq+1;
            }
            else
            {
                if(matrix.charAt(i)!='0')flag=-1;
            }
        }
      if(flag==0)return "True";
      else return "False";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {


        String matrix = request.getParameter("matrix").replaceAll("\\s","");
        String transpose=request.getParameter("Transpose");
        String identity = request.getParameter("IsIdentity");

            // matrix Transpose IsIdentity
        response.setContentType("text/html");
        int sz=matrix.length();
        int sq=(int)Math.sqrt(sz);
        int ok2=0;
        String page;
        for(int i=0;i< sz;i++)
        {
            if(matrix.charAt(i)<'0'||matrix.charAt(i)>'9')
            {
                ok2=-1;
                break;
            }
        }
        if(sq*sq!=sz||ok2==-1 || sz==0)
        {
            page="\n" +
                    "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "\t<body bgcolor=\"#f0f0f0\" align=\"center\" >\n" +
                    "\t<h1 align=\"center\">please enter a valid square matrix</h1>\n" +
                    "\t\t\n" +
                    "\t</body>\n" +
                    "</html>\n";
        }
        else {

            String original=get_matrix(matrix,sq);

            if(transpose!=null && identity!=null)
            {
                String trans=transpose(matrix,sq,sz);
                String ident=isidentity(matrix,sq,sz);

                page="<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "\t<body bgcolor=\"#f0f0f0\" align=\"center\" >\n" +
                        "\t\t<h1 align=\"center\"> Result </h1>\n" +
                        "\t\t\n" +
                        "\t\t\n" +
                        "\t\t<h2 align=\"center\">Original Matrix</h2>\n" +
                        "\t\t<h2 align=\"center\">"+ original +" </h2>\n" +
                        "\t\t<h2 align=\"center\"> Transpose </h2>\n" +
                        "\t\t<h2 align=\"center\"> "+ trans +"  </h2>\n" +
                        "\t\t\n" +
                        "\t\t<h2 align=\"center\">identity</h2>\n" +
                        "\t\t<h2 align=\"center\">" + ident+ " </h2>\n" +
                        "\t\t\n" +
                        "\t</body>\n" +
                        "</html>\n";
            }
            else if(transpose!=null)
            {
                String trans=transpose(matrix,sq,sz);


                page="<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "\t<body bgcolor=\"#f0f0f0\" align=\"center\" >\n" +
                        "\t\t<h1 align=\"center\"> Result </h1>\n" +
                        "\t\t\n" +
                        "\t\t\n" +
                        "\t\t<h2 align=\"center\">Original Matrix</h2>\n" +
                        "\t\t<h2 align=\"center\">"+ original +" </h2>\n" +
                        "\t\t<h2 align=\"center\">Transpose </h2>\n" +
                        "\t\t<h2 align=\"center\"> "+ trans +"  </h2>\n" +
                        "\t\t\n" +
                        "\t\t\n" +
                        "\t</body>\n" +
                        "</html>\n";
            }
            else if(identity!=null)
            {

                String ident=isidentity(matrix,sq,sz);

                page="<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "\t<body bgcolor=\"#f0f0f0\" align=\"center\" >\n" +
                        "\t\t<h1 align=\"center\"> Result </h1>\n" +
                        "\t\t\n" +
                        "\t\t\n" +
                        "\t\t<h2 align=\"center\">Original Matrix</h2>\n" +
                        "\t\t<h2 align=\"center\">"+ original +" </h2>\n" +
                        "\t\t\n" +
                        "\t\t<h2 align=\"center\">identity</h2>\n" +
                        "\t\t<h2 align=\"center\">"+ ident+" </h2>\n" +
                        "\t\t\n" +
                        "\t</body>\n" +
                        "</html>\n";
            }
            else
            {
                page = "\n" +
                        "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "\t<body bgcolor=\"#f0f0f0\" align=\"center\" >\n" +
                        "\t\t<h1 align=\"center\"> Result </h1>\n" +
                        "\t\t\n" +
                        "\t\t\n" +
                        "\t\t<h2 align=\"center\">Original Matrix</h2>\n" +
                        "\t\t<h2 align=\"center\"> " + original + "</h2>\n" +
                        "\t\t\n" +
                        "\t</body>\n" +
                        "</html>\n";
            }


        }

        try {
            response.getWriter().println(page);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}