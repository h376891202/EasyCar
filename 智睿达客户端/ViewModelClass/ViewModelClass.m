//
//  ViewModelClass.m
//  智睿达客户端
//
//  Created by tony1220 on 15/4/27.
//  Copyright (c) 2015年 tony1220. All rights reserved.
//

#import "ViewModelClass.h"

@implementation ViewModelClass

#pragma 获取网络可到达状态
-(BOOL) netWorkState
{
    return [BaseRequest netWorkReachability];
    
}

#pragma 接收传过来的block
-(void) setBlockWithReturnBlock: (ReturnValueBlock) returnBlock
                 WithErrorBlock: (ErrorCodeBlock) errorBlock
               WithFailureBlock: (FailureBlock) failureBlock
{
    _returnBlock = returnBlock;
    _errorBlock = errorBlock;
    _failureBlock = failureBlock;
}


@end
