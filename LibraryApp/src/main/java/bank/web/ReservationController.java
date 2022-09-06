package bank.web;

import bank.domain.*;
import bank.service.BorrowRecordService;
import bank.service.ReservationService;
import bank.service.ReturnRecordService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reservations")
public class ReservationController {


    @Autowired
    ReservationService reservationService;

    @Autowired
    BorrowRecordService borrowRecordService;

    @Autowired
    ReturnRecordService returnRecordService;

    /*@GetMapping
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }*/

    @PostMapping("/{id}")
    public Reservation createReservation(@RequestBody ReservationRequest reservationRequest, @PathVariable int id){
        return reservationService.addReservation(reservationRequest, id);
    }

    @PostMapping("/borrow/{id}")
    public BorrowRecord createBorrowRecord(@RequestBody BorrowRequest borrowRequest, @PathVariable Integer id) throws JsonProcessingException {
        return borrowRecordService.addBorrowRecord(borrowRequest, id);
    }

   /* @GetMapping("/borrow/{id}")
    public BorrowRecord getBorrowRecord(@PathVariable Integer id){
        return borrowRecordService.getBorrowRecord(id);
    }*/

    @PostMapping("/return/{id}")
    public ReturnRecord createReturnRecord(@RequestBody ReturnRequest returnRequest, @PathVariable Integer id) throws JsonProcessingException {
        return returnRecordService.addReturnRecord(returnRequest, id);
    }

    /*@DeleteMapping("/{id}")
    public void cancelReservation( @PathVariable String id ){
        reservationService.cancelReservation(id);
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable String id){
        return reservationService.getReservationById(id);
    }*/
}
