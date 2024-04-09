package hello.core.member;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Primary
public class MemoryMemberRepository implements MemberRepository{

    //여러곳에서 동시에 접근을 하면 문제가 생겨 concurrent해시맵을 쓰는게 맞음
    private static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
