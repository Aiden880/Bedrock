/**
 * This file is part of Bedrock, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2016 Helion3 http://helion3.com/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.helion3.bedrock.commands;

import com.helion3.bedrock.Bedrock;
import com.helion3.bedrock.managers.AfkManager;
import com.helion3.bedrock.util.Format;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Aiden on 21/02/2016.
 */
public class AfkCommand {
    private AfkCommand() {}
    public static CommandSpec getCommand() {
        return CommandSpec.builder()
                .arguments(
                        GenericArguments.playerOrSource(Text.of("player"))
                )
                .description(Text.of("Toggle player as AFK."))
                .permission("bedrock.afk")
                .executor((source, args) -> {

                    // Check if source is Player
                    if(!(source instanceof Player)) {
                        source.sendMessage(Format.error("Only players may use this command."));
                        return CommandResult.empty();
                    }

                    // Define player as the source, confirmed instance of Player
                    Player player = (Player) source;

                    // Set user as AFK.
                    // @TODO: 21/02/2016 Remember to add logic to kick player after x time
                    // Add user to afklist
                    AfkManager.afkPlayers.add(player);

                    // Send message to "TO_ALL" message channel, build the text
                    MessageChannel.TO_ALL.send(Text.builder(player.getName() + " is now AFK.").build());
                    return CommandResult.success();
                }).build();
    }
}

