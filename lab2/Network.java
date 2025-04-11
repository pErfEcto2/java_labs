package lab2;

import java.util.ArrayList;

public class Network {
    public class Member {
        private String name;
        private ArrayList<Member> friends;

        public Member(String name) {
            this.name = name;
            friends = new ArrayList();
        }

        public void leave() {
            unenroll(this);
        }

        public boolean belongsTo(Network n) {
            return Network.this == n;
        }
    }
    private ArrayList<Member> members;

    public Member enroll(String name) {
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }

    public void unenroll(Member m) {
        members.remove(m);
    }

    public static void main(String[] args) {

    }
}