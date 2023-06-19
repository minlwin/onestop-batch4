export interface ApiResult {
  status:AipStatus
  result:string[] | PageResult | any [] | any
}

export interface PageResult {
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
