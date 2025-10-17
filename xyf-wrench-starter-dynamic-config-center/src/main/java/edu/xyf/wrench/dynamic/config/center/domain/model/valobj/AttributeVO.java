package edu.xyf.wrench.dynamic.config.center.domain.model.valobj;

/**
 * @Author: Xuyifeng
 * @Description: 属性值调整值对象
 * @Date: 2025/10/17 15:20
 */

public class AttributeVO {

    /**
     * 键 - 属性 fileName
     */
    private String attribute;

    /**
     * 值
     */
    private String value;

    public AttributeVO() {
    }

    public AttributeVO(String attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
