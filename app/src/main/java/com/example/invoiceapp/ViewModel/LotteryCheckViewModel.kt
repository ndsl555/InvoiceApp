package com.example.invoiceapp.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.invoiceapp.Entity.InvoiceNumber
import com.example.invoiceapp.UseCase.LotteryCheckUseCase
import com.example.invoiceapp.Utils.Result
import com.example.invoiceapp.Utils.invoke
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LotteryCheckViewModel(
    private val useCase: LotteryCheckUseCase,
) : ViewModel() {
    private val _lotteryNumber =
        MutableStateFlow(InvoiceNumber("", "", emptyList()))
    val lotteryNumber: StateFlow<InvoiceNumber> = _lotteryNumber.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        getLotteryNumber()
    }

    fun getLotteryNumber() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                when (val result = useCase.invoke()) {
                    is Result.Success -> {
                        _lotteryNumber.value = result.data
                    }
                    is Result.Error -> {
                        Log.e(
                            "LotteryCheckViewModel",
                            "Error getting lottery number",
                            result.exception,
                        )
                    }
                }
            } finally {
                _isLoading.value = false
            }
        }
    }
}
