package com.jiawa.train.member.req;

public class PassengerQueryReq {

        private long memberId;


        public long getMemberId() {
            return memberId;
        }

        public void setMemberId(long memberId) {
            this.memberId = memberId;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("PassengerQueryReq{");
            sb.append("memberId=").append(memberId);
            sb.append('}');
            return sb.toString();
        }
}
