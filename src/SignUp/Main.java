package SignUp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        String line = "", data, status = "success";
        String[] names = {"parentName", "phone", "email", "kidName", "age", "grade", "comments"};
        for (String name : names) {
            data = request.getParameter(name);
            if(data == null) {
                status = "failed";
                break;
            }
            line += data + ",";
        }
        
        if(status.equals("success")) {
            
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yy hh:mm a");
            System.out.println(format.format(date));
            
            line = format.format(date) + "," + line;
            
            File file = new File(getServletContext().getRealPath("../") + "/signup.csv");
            if(!file.exists()) {
                file.createNewFile();
            }

            try {
                PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsolutePath(), true)));
                fileWriter.println(line);
                fileWriter.close();
            } catch (IOException e) {
                status = "failed";
            }
        }
        
        response.sendRedirect(request.getContextPath() + "?status=" + status);
    }
}
