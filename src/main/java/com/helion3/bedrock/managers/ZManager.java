package com.helion3.bedrock.managers;

import com.helion3.bedrock.NamedConfiguration;
import ninja.leaping.configurate.ConfigurationNode;
import org.spongepowered.api.text.Text;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aiden on 23/02/2016.
 */
public class ZManager {
    private final Map<String,String> macroList = new HashMap<>();

    private final NamedConfiguration config;

    public ZManager() { config = new NamedConfiguration("macros"); }

    public void getMacros() {
        ConfigurationNode node = config.getRootNode().getNode();
        if(!config.getNode().getChildrenMap().isEmpty()) {
            config.getNode().getChildrenMap().keySet().stream().filter(obj -> obj instanceof String).forEach(obj -> {
                macroList.put((String) obj,"");
            });
        }

    }




}
