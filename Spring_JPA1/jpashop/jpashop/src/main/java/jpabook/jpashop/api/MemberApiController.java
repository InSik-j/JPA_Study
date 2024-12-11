package jpabook.jpashop.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    /** 조회 V1: 응답 값으로 엔티티를 직접 외부에 노출한다. */
    @GetMapping("/api/v1/members")
    public List<Member> membersV1(){
        return memberService.findMembers();
    }

    /** 조회 V2: 응답 값으로 엔티티가 아닌 별도의 DTO를 반환한다. */
    @GetMapping("/api/v2/members")
    public Result membersV2() {
        List<Member> findMembers = memberService.findMembers();

        // 엔티티 -> DTO 변환
        List<MemberDto> collect = findMembers.stream()
                                             .map(m -> new MemberDto(m.getName()))
                                             .collect(Collectors.toList());

        return new Result(collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String name;
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
