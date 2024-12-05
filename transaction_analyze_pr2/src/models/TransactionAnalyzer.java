package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionAnalyzer {
    private final List<Transaction> transactions;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public TransactionAnalyzer(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double calculateTotalBalance() {
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }

    public int countTransactionsByMonth(String monthYear) {
        return (int) transactions.stream()
                .filter(t -> {
                    LocalDate date = LocalDate.parse(t.getDate(), dateFormatter);
                    return date.format(DateTimeFormatter.ofPattern("MM-yyyy")).equals(monthYear);
                })
                .count();
    }

    public List<Transaction> findTopExpenses() {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }
}
