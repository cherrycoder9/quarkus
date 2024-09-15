package codemaster

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import java.io.InputStream

@Path("/")
class WebPageResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    fun getHelloWorldPage(): Response {
        val htmlContent: InputStream? = javaClass.getResourceAsStream("/META-INF/resources/hello.html")
        return if (htmlContent != null) {
            Response.ok(htmlContent).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).entity("File not found").build()
        }
    }
}
