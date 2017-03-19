/*
 * * Copyright (C) 2017 Matt Baxter http://kitteh.org
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.kitteh.laggbegone;

import com.google.inject.Inject;
import org.spongepowered.api.Game;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;

import javax.annotation.Nonnull;

/**
 * Gets all the lagg out of your server!
 */
@Plugin(id = "laggbegone", name = "LaggBeGone", version = "1.0.0-SNAPSHOT")
public class LaggBeGone {
    public static final String PERMISSION_LAGG = "lagg.be.gone";

    /**
     * Sometimes, people make mistakes.
     */
    public static class Main {
        /**
         * Let's tell them just how wrong they are.
         *
         * @param args maybe they'll be argumentative about it later
         */
        public static void main(String[] args) {
            System.out.println();
            System.out.println("    Meow!  :3");
            System.out.println();
            System.out.println();
            System.out.println("This is a Sponge plugin. Not something to be run by itself!");
            System.out.println();
            System.out.println("    To use this plugin, you need to have Sponge.");
            System.out.println();
            System.out.println("     https://www.spongepowered.org");
            System.out.println();
            System.out.println();
        }
    }

    @Inject
    private Game game;

    @Nonnull
    Game getGame() {
        return this.game;
    }

    @Listener
    public void onGameInit(GameInitializationEvent event) {
        CommandSpec commandSpec = CommandSpec.builder().permission(PERMISSION_LAGG).executor(new LaggCommand(this)).build();
        this.game.getCommandManager().register(this, commandSpec, "lagg");
    }
}
