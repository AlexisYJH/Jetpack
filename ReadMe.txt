$$lifecycle
- 使用LifeCycle解耦页面和组件
- 使用LifeCycle解耦Service和组件
- 使用ProcessLifecycleOwner监听应用程序生命周期

$$viewmodel
ViewModel应用

$$livedata
LiveData应用1：在ViewModel中的数据发生变化时通知页面

$$livedata2
LiveData应用2：ViewModel+LiveData实现Fragment间通信

$$databinding
DataBinding应用，import标签和事件绑定

$$databinding2
二级页面的绑定

$$databinding3
自定义BindingAdapter加载网络图片

$$databinding4
双向绑定之BaseObservable

$$databinding5
双向绑定之ObservableField

$$databinding6
RecycleView的绑定

$$databinding7
DataBinding+VieModel+LiveData

$$room
Room应用

$$room2
- Room+ViewModel+LiveData
- 使用Migration升级数据库，升级的异常处理，Schema文件，销毁和重建策略，预填充数据库

$$navigation
Navigation应用，动画效果和safe args传参

$$navigation2
NavigationUI应用

$$navigation3
- 深层链接DeepLink之PendingIntent
- 深层链接DeepLink之URL

$$workmanager
- 定义任务和任务执行结果
- 设置任务触发条件和延迟执行任务
- 设置指数退避策略与设置标签
- 观察任务状态与取消任务
- 参数传递
- 周期性任务
- 任务链与任务组合

$$paging
- PositionalDataSource与DataSource.Factory具体实现
- ViewModel中配置PagedList
- PagedListAdapter与DiffUtil

$$paging2
PagedKeyedDataSource，适用于数据源以页的方式进行请求的情况

$$paging3
ItemKeyedDataSource，适用于目标数据的下一页需要依赖上一页数据中最后一个对象的某个字段作为key的情况，常见于评论功能的实现

$$paging4
- 数据库的Room操作
- BoundaryCallback具体实现（网络数据存入数据库）BoundaryCallback无网络情况下有数据库缓存
- PagedList的配置（从数据库中读取数据）
- 下拉刷新处理