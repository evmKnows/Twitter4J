/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package examples.directmessage;

import twitter4j.*;

/**
 * Example application that sends a message to specified Twitter-er from specified account.<br>
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @author Hiroaki TAKEUCHI - takke30 at gmail.com
 */
public final class SendDirectMessage {
    /**
     * Usage: java twitter4j.examples.directMessage.DirectMessage [recipient screen name] [message]
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java twitter4j.examples.directmessage.SendDirectMessage [recipient id] [message]");
            System.exit(-1);
        }
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            DirectMessage message = twitter.sendDirectMessage(Long.parseLong(args[0]), args[1]);
            System.out.println("Direct message successfully sent to " + message.getId());
            System.out.println(" details:" + message);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to send a direct message: " + te.getMessage());
            System.exit(-1);
        }
    }
}
