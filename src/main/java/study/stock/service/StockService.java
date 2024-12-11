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
public class StockService {

    protected final StockRepository stockRepository;

    @Transactional
    public void decrease(Long id, Long quantity) {
        // Stock 조회
        // 재고를 감소 후,
        // 갱신된 값을 저장
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);
        stockRepository.save(stock);
    }
}
