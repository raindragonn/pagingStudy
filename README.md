# Paging 3


 ## 페이징 라이브러리를 사용하는 이유

 - 페이징된 데이터의 메모리 캐싱 이로인한 시스템 리소스를 효율적으로 사용할 수 있다.
 
 - 요청 중복 제거 기능 지원
 
 - RecyclerView 의 스크롤을 통한 데이터로드를 지원
 
 - 새로고침, 재시도, 오류 처리를 지원
 
 
 ## 아키텍처
 
 > 페이징 라이브러리는 권장 Android 앱 아키텍처에 통합되도록 만들어 졌습니다.

1. Repository Layer

- `PagingSource` : 데이터 소스를 정의하고 데이터를 가져오는 방법을 정의

- `RemoteMediator` : 로컬 데이터베이스를 이용해 네트워크 데이터를 캐싱하기 위해 사용됩니다.(7월 29일 기준 현재는 실험용으로 나와으며 향후 변경될 수 있습니다.)

2. ViewModel Layer

- `Pager` : PagingSource 와 PagingConfig 로 구성되며 PagingData 를 반응형 스트림으로 생성할 수 있습니다.

3. UI Layer

- `PagingDataAdapter` : Paging3 에서 지원하는 RecyclerView 의 어댑터이며, PagingData 를 받아서 처리해줍니다.(ListAdapter 와 같이 DiffUtil 을 통해 데이터를 새로고침 해 줍니다.)