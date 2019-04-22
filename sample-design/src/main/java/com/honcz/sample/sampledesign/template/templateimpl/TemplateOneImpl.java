package com.honcz.sample.sampledesign.template.templateimpl;

import com.honcz.sample.sampledesign.template.Template;

/**
 * @author honc.z
 * @date 2019/4/19
 *
 * 模板一
 */
public class TemplateOneImpl extends Template {
    @Override
    public String execute(String id) {
        return "this is template one";
    }
}
