package poc.quarkus.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.http.HttpServerRequest;

@Provider
public class CustomRequestFilter implements ContainerRequestFilter {

	private static final Logger LOG = LoggerFactory.getLogger(CustomRequestFilter.class);
	
	@Context
    private UriInfo info;

    @Context
    private HttpServerRequest request;
    
	@Override
	public void filter(ContainerRequestContext context) throws IOException {
		final String method = context.getMethod();
        final String path = info.getPath();
        final String address = request.remoteAddress().toString();

        LOG.info("Request {} {} from IP {}", method, path, address);
		
	}

}
