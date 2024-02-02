//package introduce.board.API;
//
//import introduce.board.DTO.ReplyDTO;
//import introduce.board.Repository.ReplyRepository;
//import introduce.board.Service.ReplyService;
//import jakarta.validation.Valid;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDateTime;
//
//@RestController
//@RequiredArgsConstructor
//public class ReplyAPI {
//
//    private final ReplyService replyService;
//    private final ReplyRepository replyRepository;
//
//    //댓글 작성 API
//    @PostMapping("/api/board/{boardId}/reply")
//    public CreateReplyResponse saveReply(@PathVariable("boardId") Long boardId, @RequestBody @Valid CreateReplyRequest request) {
//        ReplyDTO replyDTO = new ReplyDTO(request.replyId, request.replyContent, request.replyCreateAt, request.boardId);
//        return null;
//    }
//
////    @PostMapping("/api/board/{id}/reply")
////    public List<ReplyDTO> saveReply2(@PathVariable("id") Long id){
////        List<ReplyEntity> result=replyRepository.findAll();
////        return null;
////    }
//
//
//    @Data
//    @AllArgsConstructor
//    static class CreateReplyResponse {
//        private Long replyId;
//    }
//
//    @Data
//    static class CreateReplyRequest {
//        private Long replyId;
//        private String replyContent;
//        private LocalDateTime replyCreateAt;
//    }
//
//
//}
