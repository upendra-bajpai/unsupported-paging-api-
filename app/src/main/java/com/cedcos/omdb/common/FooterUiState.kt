package com.cedcos.omdb.common

import android.content.Context
import android.util.Log
import androidx.paging.LoadState
import com.cedcos.omdb.R

/**
 * Created by Upendra on
 *
 *
 */
data class FooterUiState(private val loadState: LoadState) : BaseUiState() {

    fun getLoadingVisibility() = getViewVisibility(isVisible = loadState is LoadState.Loading)

    fun getErrorVisibility() = getViewVisibility(isVisible = loadState is LoadState.Error)

    fun getErrorMessage(context: Context) = if (loadState is LoadState.Error) {
        loadState.error.localizedMessage ?: context.getString(R.string.something_went_wrong)
    } else ""
}
