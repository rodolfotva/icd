package com.tva.icd.resolver;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.LocaleResolver;

public class UrlLocaleResolver implements LocaleResolver {

  private static final String URL_LOCALE_ATTRIBUTE_NAME = "URL_LOCALE_ATTRIBUTE_NAME";

  @Override
  public Locale resolveLocale(HttpServletRequest request) {
    String uri = request.getRequestURI();
    System.out.println("URI=" + uri);

    String prefixEn = request.getServletContext().getContextPath() + "/en/";
    String prefixFr = request.getServletContext().getContextPath() + "/fr/";
    String prefixPt = request.getServletContext().getContextPath() + "/pt/";

    Locale locale = null;

    // English
    if (uri.startsWith(prefixEn)) {
      locale = Locale.ENGLISH;
    }
    // French
    else if (uri.startsWith(prefixFr)) {
      locale = Locale.FRANCE;
    }
    // Portuguese
    else if (uri.startsWith(prefixPt)) {
      locale = new Locale("pt", "BR");
    }
    if (locale != null) {
      request.getSession().setAttribute(URL_LOCALE_ATTRIBUTE_NAME, locale);
    }
    if (locale == null) {
      locale = (Locale) request.getSession().getAttribute(URL_LOCALE_ATTRIBUTE_NAME);
      if (locale == null) {
        locale = Locale.ENGLISH;
      }
    }
    return locale;
  }

  @Override
  public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {}
}
