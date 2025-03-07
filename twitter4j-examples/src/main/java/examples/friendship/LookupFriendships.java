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

package examples.friendship;

import twitter4j.*;

/**
 * Looks up friendships.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class LookupFriendships {
    /**
     * Usage: java twitter4j.examples.user.LookupFriendships [screen name[,screen name..]]
     *
     * @param args message
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(
                    "Usage: java twitter4j.examples.user.LookupFriendships [screen name[,screen name..]]");
            System.exit(-1);
        }
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            ResponseList<Friendship> friendships = twitter.lookupFriendships(args[0].split(","));
            for (Friendship friendship : friendships) {
                System.out.println("@" + friendship.getScreenName()
                        + " following: " + friendship.isFollowing()
                        + " followed_by: " + friendship.isFollowedBy());
            }
            System.out.println("Successfully looked up friendships [" + args[0] + "].");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to lookup friendships: " + te.getMessage());
            System.exit(-1);
        }
    }
}
