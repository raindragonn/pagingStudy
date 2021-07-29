package com.raindragonn.pagingstudy.data.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.raindragonn.pagingstudy.data.model.TrackItem
import com.raindragonn.pagingstudy.data.remote.RemoteDataSource
import retrofit2.HttpException
import java.io.IOException

/**
 * 데이터 소스 정의 및 데이터를 가져오는 방법 정의
 * 키의 유형은 offset 이용 하므로 Int
 * 데이터 유형은 TrackItem
 * 데이터를 가져오는 위치 = RemoteDataSource
 */
class ItunesPagingSource(
    private val remoteDataSource: RemoteDataSource
) : PagingSource<Int, TrackItem>() {

    /**
     * 사용자가 스크롤할 때 데이터를 비동기식으로 가져오기 위한 Load 함수 구현
     * LoadParams 객체에는 로드할 페이지의 키 와 로드 크기 정보가 저장됩니다.
     * 초기에는 key 가 null 이며, loadSize 는 가져온 데이터의 크기를 뜻합니다.
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TrackItem> {
        val position = params.key ?: 0

        return try {
            val response = remoteDataSource.getTrackItemList(
                limit = params.loadSize,
                offset = position
            )

            val nextKey = if (response.isEmpty()) {
                null
            } else {
                position + params.loadSize
            }

            LoadResult.Page(
                data = response,
                prevKey = if (position == 0) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    /**
     * 새로고침 시 사용됩니다.
     * 가장 최근 인덱스를 anchorPosition 을 이용해 주변 데이터의 로드를 다시 시작
     */
    override fun getRefreshKey(state: PagingState<Int, TrackItem>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}