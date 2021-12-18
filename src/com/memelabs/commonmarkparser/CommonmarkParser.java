package com.memelabs.commonmarkparser;

import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.YailList;
import org.commonmark.Extension;
import org.commonmark.ext.ins.InsExtension;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import io.github.furstenheim.CopyDown;

import java.util.Arrays;
import java.util.List;

public class CommonmarkParser extends AndroidNonvisibleComponent {

  public CommonmarkParser(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleFunction(description = "Converts markdown formatted text into HTML")
  public String ConvertMarkdownToHtml(String Markdown) {
    List<Extension> extensions = Arrays.asList(InsExtension.create());
    Parser parser = Parser.builder().extensions(extensions).build();
    Node document = parser.parse(Markdown);
    HtmlRenderer htmlRenderer = HtmlRenderer.builder().extensions(extensions).build();
    return htmlRenderer.render(document);
  }

  @SimpleFunction(description = "Converts HTML into Markdown formatted text")
  public String ConvertHtmlToMarkdown(String Html) {
    CopyDown converter = new CopyDown();
    String markdown = converter.convert(Html);
    return markdown;
  }
}
