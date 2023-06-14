export interface ApiResult {
  status:AipStatus
  result:string[] | ListResult | any [] | any
}

export interface ListResult {
  list:any[]
  pager:Pager
}

export interface Pager {
  current: number
  size: number
  totalCount: number
  totalPage:number
}

export declare type AipStatus = 'Success' | 'Auth' | 'Business'
