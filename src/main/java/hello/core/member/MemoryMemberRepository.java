package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private final static Map<Long, Member> store = new HashMap<>();
    // 동시 환경에서는 ConcurrentHashMap을 사용해야 한다.

    @Override
    public void sava(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
