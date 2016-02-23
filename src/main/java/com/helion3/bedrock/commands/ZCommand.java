package com.helion3.bedrock.commands;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.command.TabCompleteEvent;
import org.spongepowered.api.text.Text;

import java.util.Optional;

/**
 * Created by Aiden on 23/02/2016.
 */
public class ZCommand {
    private ZCommand() {}

    public static CommandSpec getCommand() {
        return CommandSpec.builder()
                .description(Text.of("Broadcast message of <key>"))
                .permission("bedrock.macro")
                .executor((source,args) -> {
                    Optional<String> key = args.<String>getOne("key");
                    if(!key.isPresent()) {

                        return CommandResult.success();
                    }
                    return CommandResult.success();
                }).build();
    }
}
