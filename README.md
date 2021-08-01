# Paging 3

### 페이징이란?
페이징은 대량의 데이터를 한 번에 불러오는 것이 아니라

필요한 만큼 `일부분을 나눠서 가져오는 것`을 의미합니다.

API에 따라 `limit(한 번에 보여줄 데이터의 수), offset(데이터의 인덱스)` 등으로

페이징 처리 되어 있습니다.

## Android JetPack Paging 3 사용 이유

1. 페이징 된 데이터의 메모리 캐싱으로 시스템 리소스를 효율적으로 사용할 수 있다.
2. 요청 중복 제거 기능 지원
3. RecyclerView 의 스크롤 할 때 자동으로 데이터로드를 지원
4. 새로 고침, 재시도, 오류 처리를 지원
 

## Paging3 아키텍처

페이징 라이브러리는 [안드로이드 권장 아키텍처][권장아키텍처]에 맞게 설계 되어있으며 총 3개의 Layer로 구성 됩니다.

1. Repository Layer
- `PagingSource` : 데이터 소스를 정의하고 데이터를 가져오는 방법을 정의
- `RemoteMediator` : 로컬 데이터베이스를 이용해 네트워크 데이터를 캐싱하기 위해 사용됩니다.(7월 29일 기준 실험용으로 나와있으며 향후 변경될 수 있습니다.)

2. ViewModel Layer
- `Pager` : PagingSource를 리턴타입으로 하는 람다와 PagingConfig를 생성자로 받으며 PagingData 를 반응형 스트림으로 생성할 수 있습니다.
- `PagingData` : 페이징된 데이터를 담아두는 컨테이너 입니다. Paging Source에서 load한 결과를 저장하며 UI Layer의 PagingDataAdapter로 넘겨 줍니다.

3. UI Layer
- `PagingDataAdapter` : Paging3 에서 지원하는 RecyclerView 의 어댑터이며, PagingData 를 받아서 처리해줍니다.(ListAdapter 와 같이 DiffUtil 을 통해 데이터를 새로고침 해 줍니다.)


[링크](https://raindragonn.github.io/2021/07/30/TIL-Android-Paging-3/)