package com.honcz.sample.sampledesign.template;

import com.honcz.sample.sampledesign.template.templateimpl.TemplateOneImpl;

/**
 * @author honc.z
 * @date 2019/4/19
 */
public class HonczTemplateShadow {
    public static void main(String[] args){
        Template template = new TemplateOneImpl();
        System.out.println(template.execute("1"));
    }
}
