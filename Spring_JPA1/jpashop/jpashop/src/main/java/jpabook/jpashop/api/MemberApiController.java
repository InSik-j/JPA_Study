package jpabook.jpashop.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    /** 등록 V1: 요청 값으로 Member 엔티티를 직접 받는다. */
    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
        Long id = memberService.join(member);

        return new CreateMemberResponse(id);
    }

    /** 등록 V2: 요청 값으로 Member 엔티티 대신에 별도의 DTO를 받는다. */
    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());

        Long id = memberService.join(member);

        return new CreateMemberResponse(id);
    }

    /** 수정 API */
    @PutMapping("/api/v2/members/{id}")
    public UpdateMemberResponse updateMemberResponseV2(@PathVariable("id") Long id,
                                                       @RequestBody @Valid UpdateMemberRequset request) {
        memberService.update(id, request.getName());
        Member findMember = memberService.findMember(id);

        return new UpdateMemberResponse(findMember.getId(), findMember.getName());
    }

    @Data
    static class UpdateMemberRequset {
        public String name;
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse {
        public Long id;
        public String name;
    }

    @Data
    static class CreateMemberRequest {
        private String name;
    }

    @Data
    static class CreateMemberResponse {
        @NotEmpty
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }


}
