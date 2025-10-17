package edu.xyf.wrench.dynamic.config.center.config;

import edu.xyf.wrench.dynamic.config.center.types.common.Constants;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2025/10/17 15:05
 */
@ConfigurationProperties(prefix = "xyf.wrench.config", ignoreInvalidFields = true)
public class DynamicConfigCenterAutoProperties {

    /**
     * 系统名称
     */
    private String system;

    public String getKey(String attributeName) {
        return this.system + Constants.LINE + attributeName;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

}
