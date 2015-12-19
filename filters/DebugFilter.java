package filters;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

public class DebugFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext request) throws IOException {
		System.out.println("\nReceived request");
		System.out.println("URI: " + request.getUriInfo().getAbsolutePath());
		System.out.println("METHOD: " + request.getMethod());
		System.out.println("CONTENT-TYPE: " + request.getMediaType());
		System.out.println("ACCEPT-TYPES " + request.getAcceptableMediaTypes());
		System.out.println("PAYLOAD SIZE: " + request.getEntityStream().available());
		System.out.println("Headers: " + request.getHeaders().keySet());

		/*
		 * NOTE: Reading the payload stream (request.getEntityStream()) will
		 * consume the stream (preventing it from being read by anything else),
		 * and there nothing you can do about it.
		 *
		 * (In other words Mark has wasted a lot of time on this on several
		 * occasions, and this comment is here mostly to remind him not to try
		 * again.)
		 */
	}

}
