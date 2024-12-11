package study.stock.service;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.stock.domain.Stock;
import study.stock.repository.StockRepository;

@Getter
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PessimisticLockStockService {
    
    private final StockRepository stockRepository;


    @Transactional
    public void decrease(Long id, Long quantity) {
        Stock stock = stockRepository.findByIdWithPessimisticLock(id).orElseThrow();
        stock.decrease(quantity);
        stockRepository.save(stock);
    }

}
