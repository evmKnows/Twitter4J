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

package examples.list;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * Updates the specified list.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class UpdateUserList {
    /**
     * Usage: java twitter4j.examples.list.UpdateUserList [list id] [new list name] [new description]
     *
     * @param args message
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java twitter4j.examples.list.UpdateUserList [list id] [new list name] [new description]");
            System.exit(-1);
        }
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            twitter.updateUserList(Integer.parseInt(args[0]), args[1], true, args[2]);
            System.out.println("Successfully updated list [" + args[0] + "].");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to update list: " + te.getMessage());
            System.exit(-1);
        }
    }
}
