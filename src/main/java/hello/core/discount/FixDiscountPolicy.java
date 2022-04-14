package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * 정액 할인 정책
 */
public class FixDiscountPolicy implements DiscountPolicy {

    private final int DISCOUNT_fIX_AMOUNT = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return DISCOUNT_fIX_AMOUNT;
        } else {
            return 0;
        }
    }
}
