@Module
package org.w3c.dom.css;

import org.w3c.css.DocumentStyle;
import org.w3c.css.MediaList;
import org.w3c.css.StyleSheet;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.views.AbstractView;


// Introduced in DOM Level 2:
public native interface CSSRuleList {
// readonly attribute unsigned 
	long length{}
	CSSRule item(final /*unsigned*/ long index);
}

// Introduced in DOM Level 2:
public native interface CSSRule {

 // RuleType
// const unsigned 
	short UNKNOWN_RULE = 0;
// const unsigned 
	short STYLE_RULE = 1;
// const unsigned 
	short CHARSET_RULE = 2;
// const unsigned 
	short IMPORT_RULE = 3;
// const unsigned 
	short MEDIA_RULE = 4;
// const unsigned 
	short FONT_FACE_RULE = 5;
// const unsigned 
	short PAGE_RULE = 6;

// readonly attribute unsigned 
	native short type{}
// attribute 
	native String cssText{}
 // throws DOMException) on setting

// readonly attribute 
	native CSSStyleSheet parentStyleSheet{}
// readonly attribute 
	native CSSRule parentRule{}
}

// Introduced in DOM Level 2:
public native interface CSSStyleRule extends CSSRule {
// attribute 
	native String selectorText{}
 // throws DOMException) on setting

// readonly attribute 
	native CSSStyleDeclaration style{}
}

// Introduced in DOM Level 2:
public native interface CSSMediaRule extends CSSRule {
// readonly attribute stylesheets::
	native MediaList media{}
// readonly attribute 
	native CSSRuleList cssRules{}
	/*unsigned*/ long insertRule(final String rule, final /*unsigned*/ long index) throws DOMException;
	void deleteRule(final /*unsigned*/ long index) throws DOMException;
}

// Introduced in DOM Level 2:
public native interface CSSFontFaceRule extends CSSRule {
// readonly attribute 
	native CSSStyleDeclaration style{}
}

// Introduced in DOM Level 2:
public native interface CSSPageRule extends CSSRule {
// attribute 
	String selectorText{}
 // throws DOMException) on setting

// readonly attribute 
	native CSSStyleDeclaration style{}
}

// Introduced in DOM Level 2:
public native interface CSSImportRule extends CSSRule {
// readonly attribute 
	native String href{}
// readonly attribute stylesheets::
	native MediaList media{}
// readonly attribute 
	native CSSStyleSheet styleSheet{}
}

// Introduced in DOM Level 2:
public native interface CSSCharsetRule extends CSSRule {
// attribute 
	native String encoding{}
 // throws DOMException) on setting

}

// Introduced in DOM Level 2:
public native interface CSSUnknownRule extends CSSRule {
}

// Introduced in DOM Level 2:
public native interface CSSStyleDeclaration extends CSS2Properties{
// attribute 
	native String cssText{}
 // throws DOMException) on setting

	String getPropertyValue(final String propertyName);
	CSSValue getPropertyCSSValue(final String propertyName);
	String removeProperty(final String propertyName) throws DOMException;
	String getPropertyPriority(final String propertyName);
	void setProperty(final String propertyName, final String value, final String priority) throws DOMException;
//	readonly attribute /*unsigned*/ 
	native long length{}
	String item(final /*unsigned*/ long index);
//	readonly attribute 
	native CSSRule parentRule{}
}

// Introduced in DOM Level 2:
public native interface CSSValue {

 // UnitTypes
// const unsigned 
	static final short CSS_INHERIT = 0;
// const unsigned 
	static final short CSS_PRIMITIVE_VALUE = 1;
// const unsigned 
	static final short CSS_VALUE_LIST = 2;
// const unsigned 
	static final short CSS_CUSTOM = 3;

// attribute 
	native String cssText{}
 // throws DOMException) on setting

// readonly attribute unsigned 
	native short cssValueType{}
}

// Introduced in DOM Level 2:
public native interface CSSPrimitiveValue extends CSSValue {

 // UnitTypes
// const unsigned 
	static final short CSS_UNKNOWN = 0;
// const unsigned 
	static final short CSS_NUMBER = 1;
// const unsigned 
	static final short CSS_PERCENTAGE = 2;
// const unsigned 
	static final short CSS_EMS = 3;
// const unsigned 
	static final short CSS_EXS = 4;
// const unsigned 
	static final short CSS_PX = 5;
// const unsigned 
	static final short CSS_CM = 6;
// const unsigned 
	static final short CSS_MM = 7;
// const unsigned 
	static final short CSS_IN = 8;
// const unsigned 
	static final short CSS_PT = 9;
// const unsigned 
	static final short CSS_PC = 10;
// const unsigned 
	static final short CSS_DEG = 11;
// const unsigned 
	static final short CSS_RAD = 12;
// const unsigned 
	static final short CSS_GRAD = 13;
// const unsigned 
	static final short CSS_MS = 14;
// const unsigned 
	static final short CSS_S = 15;
// const unsigned 
	static final short CSS_HZ = 16;
// const unsigned 
	static final short CSS_KHZ = 17;
// const unsigned 
	static final short CSS_DIMENSION = 18;
// const unsigned 
	static final short CSS_STRING = 19;
// const unsigned 
	static final short CSS_URI = 20;
// const unsigned
	static final short CSS_IDENT = 21;
// const unsigned 
	static final short CSS_ATTR = 22;
// const unsigned
	static final short CSS_COUNTER = 23;
// const unsigned 
	static final short CSS_RECT = 24;
// const unsigned 
	static final short CSS_RGBCOLOR = 25;

// readonly attribute unsigned 
	short primitiveType{}
	void setFloatValue(final /*unsigned*/ short unitType, final float floatValue) throws DOMException;
	float getFloatValue(final /*unsigned*/ short unitType) throws DOMException;
	void setStringValue(final /*unsigned*/ short stringType, final String stringValue) throws DOMException;
	String getStringValue() throws DOMException;
	Counter getCounterValue() throws DOMException;
	Rect getRectValue() throws DOMException;
	RGBColor getRGBColorValue() throws DOMException;
}

// Introduced in DOM Level 2:
public native interface CSSValueList extends CSSValue {
// readonly attribute unsigned 
	long length{}
	CSSValue item(final /*unsigned*/ long index);
}

// Introduced in DOM Level 2:
public native interface RGBColor {
// readonly attribute 
	CSSPrimitiveValue red{}
// readonly attribute 
	CSSPrimitiveValue green{}
// readonly attribute 
	CSSPrimitiveValue blue{}
}

// Introduced in DOM Level 2:
public native interface Rect {
// readonly attribute 
	CSSPrimitiveValue top{}
// readonly attribute 
	CSSPrimitiveValue right{}
// readonly attribute 
	CSSPrimitiveValue bottom{}
// readonly attribute 
	CSSPrimitiveValue left{}
}

// Introduced in DOM Level 2:
public native interface Counter {
// readonly attribute 
	String identifier{}
// readonly attribute 
	String listStyle{}
// readonly attribute 
	String separator{}
}

// Introduced in DOM Level 2:
public native interface ElementCSSInlineStyle {
// readonly attribute 
	CSSStyleDeclaration style{}
}

// Introduced in DOM Level 2:
public native interface CSS2Properties {
// attribute 
	String azimuth{}
 // throws DOMException) on setting

// attribute 
	String background{}
 // throws DOMException) on setting

// attribute 
	String backgroundAttachment{}
 // throws DOMException) on setting

// attribute 
	String backgroundColor{}
 // throws DOMException) on setting

// attribute 
	String backgroundImage{}
 // throws DOMException) on setting

// attribute 
	String backgroundPosition{}
 // throws DOMException) on setting

// attribute 
	String backgroundRepeat{}
 // throws DOMException) on setting

// attribute 
	String border{}
 // throws DOMException) on setting

// attribute 
	String borderCollapse{}
 // throws DOMException) on setting

// attribute 
	String borderColor{}
 // throws DOMException) on setting

// attribute 
	String borderSpacing{}
 // throws DOMException) on setting

// attribute 
	String borderStyle{}
 // throws DOMException) on setting

// attribute 
	String borderTop{}
 // throws DOMException) on setting

// attribute 
	String borderRight{}
 // throws DOMException) on setting

// attribute 
	String borderBottom{}
 // throws DOMException) on setting

// attribute 
	String borderLeft{}
 // throws DOMException) on setting

// attribute 
	String borderTopColor{}
 // throws DOMException) on setting

// attribute 
	String borderRightColor{}
 // throws DOMException) on setting

// attribute
	String borderBottomColor{}
 // throws DOMException) on setting

// attribute 
	String borderLeftColor{}
 // throws DOMException) on setting

// attribute 
	String borderTopStyle{}
 // throws DOMException) on setting

// attribute 
	String borderRightStyle{}
 // throws DOMException) on setting

// attribute 
	String borderBottomStyle{}
 // throws DOMException) on setting

// attribute 
	String borderLeftStyle{}
 // throws DOMException) on setting

// attribute 
	String borderTopWidth{}
 // throws DOMException) on setting

// attribute 
	String borderRightWidth{}
 // throws DOMException) on setting

// attribute 
	String borderBottomWidth{}
 // throws DOMException) on setting

// attribute 
	String borderLeftWidth{}
 // throws DOMException) on setting

// attribute 
	String borderWidth{}
 // throws DOMException) on setting

// attribute
	String bottom{}
 // throws DOMException) on setting

// attribute 
	String captionSide{}
 // throws DOMException) on setting

// attribute
	String clear{}
 // throws DOMException) on setting

// attribute 
	String clip{}
 // throws DOMException) on setting

// attribute
	String color{}
 // throws DOMException) on setting

// attribute 
	String content{}
 // throws DOMException) on setting

// attribute 
	String counterIncrement{}
 // throws DOMException) on setting

// attribute 
	String counterReset{}
 // throws DOMException) on setting

// attribute 
	String cue{}
 // throws DOMException) on setting

// attribute 
	String cueAfter{}
 // throws DOMException) on setting

// attribute 
	String cueBefore{}
 // throws DOMException) on setting

// attribute 
	String cursor{}
 // throws DOMException) on setting

// attribute 
	String direction{}
 // throws DOMException) on setting

// attribute 
	String display{}
 // throws DOMException) on setting

// attribute 
	String elevation{}
 // throws DOMException) on setting

// attribute 
	String emptyCells{}
 // throws DOMException) on setting

// attribute 
	String cssFloat{}
 // throws DOMException) on setting

// attribute 
	String font{}
 // throws DOMException) on setting

// attribute 
	String fontFamily{}
 // throws DOMException) on setting

// attribute 
	String fontSize{}
 // throws DOMException) on setting

// attribute 
	String fontSizeAdjust{}
 // throws DOMException) on setting

// attribute 
	String fontStretch{}
 // throws DOMException) on setting

// attribute 
	String fontStyle{}
 // throws DOMException) on setting

// attribute 
	String fontVariant{}
 // throws DOMException) on setting

// attribute 
	String fontWeight{}
 // throws DOMException) on setting

// attribute 
	String height{}
 // throws DOMException) on setting

// attribute 
	String left{}
 // throws DOMException) on setting

// attribute 
	String letterSpacing{}
 // throws DOMException) on setting

// attribute 
	String lineHeight{}
 // throws DOMException) on setting

// attribute 
	String listStyle{}
 // throws DOMException) on setting

// attribute 
	String listStyleImage{}
 // throws DOMException) on setting

// attribute 
	String listStylePosition{}
 // throws DOMException) on setting

// attribute 
	String listStyleType{}
 // throws DOMException) on setting

// attribute 
	String margin{}
 // throws DOMException) on setting

// attribute 
	String marginTop{}
 // throws DOMException) on setting

// attribute 
	String marginRight{}
 // throws DOMException) on setting

// attribute 
	String marginBottom{}
 // throws DOMException) on setting

// attribute 
	String marginLeft{}
 // throws DOMException) on setting

// attribute 
	String markerOffset{}
 // throws DOMException) on setting

// attribute 
	String marks{}
 // throws DOMException) on setting

// attribute 
	String maxHeight{}
 // throws DOMException) on setting

// attribute 
	String maxWidth{}
 // throws DOMException) on setting

// attribute 
	String minHeight{}
 // throws DOMException) on setting

// attribute 
	String minWidth{}
 // throws DOMException) on setting

// attribute 
	String orphans{}
 // throws DOMException) on setting

// attribute 
	String outline{}
 // throws DOMException) on setting

// attribute 
	String outlineColor{}
 // throws DOMException) on setting

// attribute 
	String outlineStyle{}
 // throws DOMException) on setting

// attribute 
	String outlineWidth{}
 // throws DOMException) on setting

// attribute 
	String overflow{}
 // throws DOMException) on setting

// attribute 
	String padding{}
 // throws DOMException) on setting

// attribute 
	String paddingTop{}
 // throws DOMException) on setting

// attribute 
	String paddingRight{}
 // throws DOMException) on setting

// attribute 
	String paddingBottom{}
 // throws DOMException) on setting

// attribute 
	String paddingLeft{}
 // throws DOMException) on setting

// attribute 
	String page{}
 // throws DOMException) on setting

// attribute 
	String pageBreakAfter{}
 // throws DOMException) on setting

// attribute 
	String pageBreakBefore{}
 // throws DOMException) on setting

// attribute 
	String pageBreakInside{}
 // throws DOMException) on setting

// attribute 
	String pause{}
 // throws DOMException) on setting

// attribute 
	String pauseAfter{}
 // throws DOMException) on setting

// attribute 
	String pauseBefore{}
 // throws DOMException) on setting

// attribute
	String pitch{}
 // throws DOMException) on setting

// attribute 
	String pitchRange{}
 // throws DOMException) on setting

// attribute 
	String playDuring{}
 // throws DOMException) on setting

// attribute 
	String position{}
 // throws DOMException) on setting

// attribute 
	String quotes{}
 // throws DOMException) on setting

// attribute
	String richness{}
 // throws DOMException) on setting

// attribute 
	String right{}
 // throws DOMException) on setting

// attribute 
	String size{}
 // throws DOMException) on setting

// attribute
	String speak{}
 // throws DOMException) on setting

// attribute 
	String speakHeader{}
 // throws DOMException) on setting

// attribute 
	String speakNumeral{}
 // throws DOMException) on setting

// attribute 
	String speakPunctuation{}
 // throws DOMException) on setting

// attribute 
	String speechRate{}
 // throws DOMException) on setting

// attribute 
	String stress{}
 // throws DOMException) on setting

// attribute 
	String tableLayout{}
 // throws DOMException) on setting

// attribute 
	String textAlign{}
 // throws DOMException) on setting

// attribute 
	String textDecoration{}
 // throws DOMException) on setting

// attribute
	String textIndent{}
 // throws DOMException) on setting

// attribute 
	String textShadow{}
 // throws DOMException) on setting

// attribute 
	String textTransform{}
 // throws DOMException) on setting

// attribute 
	String top{}
 // throws DOMException) on setting

// attribute 
	String unicodeBidi{}
 // throws DOMException) on setting

// attribute 
	String verticalAlign{}
 // throws DOMException) on setting

// attribute 
	String visibility{}
 // throws DOMException) on setting

// attribute
	String voiceFamily{}
 // throws DOMException) on setting

// attribute 
	String volume{}
 // throws DOMException) on setting

// attribute 
	String whiteSpace{}
 // throws DOMException) on setting

// attribute 
	String widows{}
 // throws DOMException) on setting

// attribute 
	String width{}
 // throws DOMException) on setting

// attribute 
	String wordSpacing{}
 // throws DOMException) on setting

// attribute 
	String zIndex{}
 // throws DOMException) on setting

}

// Introduced in DOM Level 2:
public native interface CSSStyleSheet extends /*stylesheets::*/StyleSheet {
//	readonly attribute 
	CSSRule ownerRule{}
//	readonly attribute 
	CSSRuleList cssRules{}
	/*unsigned*/ long insertRule(final String rule, final /*unsigned*/ long index) throws DOMException;
	void deleteRule(final /*unsigned*/ long index) throws DOMException;
}

// Introduced in DOM Level 2:
public native interface ViewCSS extends /*views::*/AbstractView {
	CSSStyleDeclaration getComputedStyle(final Element elt, final String pseudoElt);
}

// Introduced in DOM Level 2:
public native interface DocumentCSS extends /*stylesheets::*/DocumentStyle {
	CSSStyleDeclaration getOverrideStyle(final Element elt, final String pseudoElt);
}

// Introduced in DOM Level 2:
public native interface DOMImplementationCSS extends DOMImplementation {
	CSSStyleSheet createCSSStyleSheet(final String title, final String media) throws DOMException;
}




