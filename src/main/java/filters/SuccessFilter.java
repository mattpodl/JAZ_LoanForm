package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("success.jsp")
public class SuccessFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();

		if (session.getAttribute("address") != null && areDataCorrect(httpRequest)) {
			chain.doFilter(request, response);
		}
		else {
			httpResponse.sendRedirect("index.jsp");
		}
	}

	private boolean areDataCorrect(HttpServletRequest httpRequest) {
		try {
			int houseNumber = Integer.parseInt(httpRequest.getParameter("houseNumber"));
			int localNumber = Integer.parseInt(httpRequest.getParameter("localNumber"));
			String phoneNumber = httpRequest.getParameter("phoneNumber");
			if (houseNumber > 0 && localNumber > 0 && phoneNumber.matches("[0-9]*")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
