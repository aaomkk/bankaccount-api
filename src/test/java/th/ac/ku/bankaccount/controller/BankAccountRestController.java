

package th.ac.ku.bankaccount.controller;

import org.springframework.web.bind.annotation.*;
import th.ac.ku.bankaccount.data.BankAccountRepository;
import th.ac.ku.bankaccount.model.BankAccount;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountRestController {

    private BankAccountRepository repository;

    public BankAccountRestController(BankAccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<BankAccount> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount getOne(@PathVariable int id) {
        try {
            return repository.findById(id).get();
        } catch(NoSuchElementException e){
            return null;
        }
    }
    @PostMapping
    public BankAccount create(@RequestBody BankAccount bankAccount) {
        BankAccount record = repository.save(bankAccount);
        repository.flush();
        return record;
    }



}
