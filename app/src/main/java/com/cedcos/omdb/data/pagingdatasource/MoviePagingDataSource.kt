package com.cedcos.omdb.data.pagingdatasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cedcos.omdb.data.model.MovieModel
import com.cedcos.omdb.network.MovieService

/**
 * PagingSource class for the process of pulling the data,responsible for the source of the paginated data.
 *@LoadParam   holds the page number to be loaded,
 * LOADSIZE*3 items during the first load
 *
 * @LoadResult as return type
 * @getRefreshKey abstract method for subsequent refresh calls to @PagingSource.load()
 */


class MoviePagingDataSource(private val userService: MovieService) :
    PagingSource<Int, MovieModel>() {
    var distance=200
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieModel> {
        val page = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = userService.getMovies()
            LoadResult.Page(
                data =if(response.isNotEmpty()) response .subList(page,page+distance)else emptyList(),
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(distance),
                nextKey = if (response.isEmpty()) null else page.plus(distance)

            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, MovieModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.nextKey?.plus(distance)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

}
