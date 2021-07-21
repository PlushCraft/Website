import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(
        description = "PlushCraft Site",
        urlPatterns = {
                "/"
        }
)
public class Website extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Website() {
        super();
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public static Server main() throws Exception {
        Server server = new Server(8187);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        handler.addServletWithMapping(Website.class, "/");
        server.start();
        return server;
    }

    public static void main(String[] args) throws Exception {
        main();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String webData = Util.getResource(getClass(), "web" + Util.processPath(request.getRequestURI()));
        if (webData == null) {
            response.setStatus(404);
            out.println(Util.getResource(getClass(), "error/404.html"));
        } else {
            out.println(webData);
        }
    }

}