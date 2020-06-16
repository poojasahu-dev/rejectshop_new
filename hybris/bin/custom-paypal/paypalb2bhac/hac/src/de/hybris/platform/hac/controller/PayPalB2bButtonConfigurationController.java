package de.hybris.platform.hac.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import paypalb2bhac.services.PayPalB2bButtonConfigurationService;

@Controller
@RequestMapping("/paypalb2bhac")
public class PayPalB2bButtonConfigurationController {

    private static final Logger LOG = Logger.getLogger(PayPalB2bButtonConfigurationController.class);

    private static final String REDIRECT_PREFIX = "redirect:";
    private static final String CART_BUTTON_CONFIG = "b2b.cart.button.config";
    private static final String MINI_CART_BUTTON_CONFIG = "b2b.mini.cart.button.config";
    private static final String MARK_BUTTON_CONFIG = "b2b.mark.button.config";
    private static final String BUTTON_CONFIG_PLACEHOLDER = "b2b.button.config.placeholder";

    @Autowired
    private PayPalB2bButtonConfigurationService payPalB2bButtonConfigurationService;

    @RequestMapping(value = "/button/config", method = RequestMethod.GET)
    public String showButtonConfigs(final Model model) {

        model.addAttribute("cartButtonConfig", payPalB2bButtonConfigurationService.getProperty(CART_BUTTON_CONFIG));
        model.addAttribute("miniCartButtonConfig", payPalB2bButtonConfigurationService.getProperty(MINI_CART_BUTTON_CONFIG));
        model.addAttribute("markButtonConfig", payPalB2bButtonConfigurationService.getProperty(MARK_BUTTON_CONFIG));
        model.addAttribute("placeholder", payPalB2bButtonConfigurationService.getProperty(BUTTON_CONFIG_PLACEHOLDER));

        return "buttonb2bConfig";
    }

    @RequestMapping(value = "/button/config/cart", method = RequestMethod.GET)
    public String saveCartButtonConfig(final Model model, @RequestParam("cartButtonConfig") final String cartButtonConfig) {

        payPalB2bButtonConfigurationService.setProperty(CART_BUTTON_CONFIG, cartButtonConfig.replaceAll("'", "\""));
        payPalB2bButtonConfigurationService.storeInPropertiesFile();

        return REDIRECT_PREFIX + "/paypalb2bhac/button/config/";
    }

    @RequestMapping(value = "/button/config/minicart", method = RequestMethod.GET)
    public String saveMiniCartButtonConfig(final Model model, @RequestParam("miniCartButtonConfig") final String miniCartButtonConfig) {

        payPalB2bButtonConfigurationService.setProperty(MINI_CART_BUTTON_CONFIG, miniCartButtonConfig.replaceAll("'", "\""));
        payPalB2bButtonConfigurationService.storeInPropertiesFile();

        return REDIRECT_PREFIX + "/paypalb2bhac/button/config/";
    }

    @RequestMapping(value = "/button/config/mark", method = RequestMethod.GET)
    public String saveMarkButtonConfig(final Model model, @RequestParam("markButtonConfig") final String markButtonConfig) {

        payPalB2bButtonConfigurationService.setProperty(MARK_BUTTON_CONFIG, markButtonConfig.replaceAll("'", "\""));
        payPalB2bButtonConfigurationService.storeInPropertiesFile();

        return REDIRECT_PREFIX + "/paypalb2bhac/button/config/";
    }
}
