package codemaster

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import java.io.InputStream

// JAX-RS @Path 어노테이션을 사용해 이 리소스가 루트 경로에 매핑됨을 지정
// JAX-RS: Java API for RESTful Web Services
@Path("/")
class WebPageResource {

    // HTTP GET 요청을 처리하는 메서드임을 나타내는 어노테이션
    @GET
    // 이 메서드가 반환하는 콘텐츠의 MIME 타입이 text/html임을 지정하는 어노테이션
    @Produces(MediaType.TEXT_HTML)
    fun getHelloWorldPage(): Response {
        // 클래스 패스에서 "/META-INF/resources/hello.html" 파일을 InputStream으로 읽음
        val htmlContent: InputStream? = javaClass.getResourceAsStream("/META-INF/resources/hello.html")
        // htmlContent가 null이 아닌 경우 (파일을 성공적으로 읽은 경우)
        return if (htmlContent != null) {
            // HTTP 200 OK 응답과 함께 HTML 콘텐츠를 반환
            Response.ok(htmlContent).build()
        } else {
            // 파일을 찾지 못한 경우, HTTP 404 Not Found 상태와 에러 메시지를 반환
            Response.status(Response.Status.NOT_FOUND).entity("File not found").build()
        }
    }
}
