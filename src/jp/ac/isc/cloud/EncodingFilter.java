package jp.ac.isc.cloud;
import java.io.*;

import javax.servlet.*;

public class EncodingFilter implements Filter{
	private String encoding = null;


	@Override
	//文字コードを取得
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		}

	@Override
	//文字コードを設定する
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)
			throws IOException, ServletException {
		//指定する
		request.setCharacterEncoding(encoding);
		//実行
		chain.doFilter(request, response);
	}
	@Override
	public void destroy() {
		encoding = null;
		}
}
