package filters;

import java.io.IOException;
import java.util.Date;

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

@WebFilter("person.jsp")
public class PersonFilter implements Filter {

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

		if (session.getAttribute("loan") != null && areDataCorrect(httpRequest)) {
			chain.doFilter(request, response);
		} else {
			httpResponse.sendRedirect("index.jsp");
		}
	}

	private boolean areDataCorrect(HttpServletRequest httpRequest) {
		try {
			int installmentCount = Integer.parseInt(httpRequest.getParameter("installmentCount"));
			int amount = Integer.parseInt(httpRequest.getParameter("amount"));
			if (amount > 0 && installmentCount > 0) {
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
