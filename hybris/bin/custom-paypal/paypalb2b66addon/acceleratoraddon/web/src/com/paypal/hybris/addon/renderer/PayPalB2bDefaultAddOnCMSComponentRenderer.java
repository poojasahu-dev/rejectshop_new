package com.paypal.hybris.addon.renderer;

import com.paypal.hybris.constants.PaypalConstants;
import de.hybris.platform.addonsupport.renderer.impl.DefaultAddOnCMSComponentRenderer;
import de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import paypalhac62.services.PayPalButtonConfigurationService;


import javax.servlet.jsp.PageContext;
import java.util.Map;

public class PayPalB2bDefaultAddOnCMSComponentRenderer<C extends AbstractCMSComponentModel> extends DefaultAddOnCMSComponentRenderer<C> {
    private static final Logger LOG = Logger.getLogger(PayPalB2bDefaultAddOnCMSComponentRenderer.class);

    private static final String B2B_PREFIX = "b2b.";
    private static final String CART_BUTTON_CONFIG = "cart.button.config";
    private static final String MINI_CART_BUTTON_CONFIG = "mini.cart.button.config";
    private static final String MARK_BUTTON_CONFIG = "mark.button.config";

    @Autowired
    private PayPalButtonConfigurationService payPalB2bButtonConfigurationService;

    @Autowired
    private ConfigurationService configurationService;

    protected Map<String, Object> exposeVariables(final PageContext pageContext, @SuppressWarnings("unused") final C component) //NOSONAR
    {
        final Map<String, Object> variables = getVariablesToExpose(pageContext, component);
            if (variables != null) {
            for (final Map.Entry<String, Object> entry : variables.entrySet()) {
                pageContext.setAttribute(entry.getKey(), entry.getValue(), getScopeForVariableName(entry.getKey()));
            }

            pageContext.setAttribute("client",
                    configurationService.getConfiguration().getString(PaypalConstants.SETT_SIGNATURE), getScopeForVariableName("client"));
            pageContext.setAttribute("env",
                        configurationService.getConfiguration().getString(PaypalConstants.PAYPAL_ENV_PROFILE), getScopeForVariableName("env"));

            String customJsConfig = "";

            if (component.getUid().equals("PayPalB2bECButtonComponent")) {
                customJsConfig = payPalB2bButtonConfigurationService.getProperty(CART_BUTTON_CONFIG);
            } else if (component.getUid().equals("PayPalB2bECMiniButtonComponent")) {
                customJsConfig = payPalB2bButtonConfigurationService.getProperty(MINI_CART_BUTTON_CONFIG);
            } else if (component.getUid().equals("PayPalB2bECMarkComponent")) {
                customJsConfig = payPalB2bButtonConfigurationService.getProperty(MARK_BUTTON_CONFIG);
            }

            if (customJsConfig.length() > 0 && !customJsConfig.endsWith(",")) {
                customJsConfig += ",";
            }

            pageContext.setAttribute("customJsConfig", customJsConfig, getScopeForVariableName("customJsConfig"));
        }
        return variables;
    }

}
