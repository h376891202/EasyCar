//
//  BaseRequest.m
//  智睿达客户端
//
//  Created by tony1220 on 15/4/27.
//  Copyright (c) 2015年 tony1220. All rights reserved.
//

#import "BaseRequest.h"

@implementation BaseRequest

#pragma 监测网络的可链接性
+ (BOOL) netWorkReachability
{
    __block BOOL netState = NO;
    
    NSURL *baseURL = [NSURL URLWithString:@"https://www.baidu.com"];
    
    AFHTTPRequestOperationManager *manager = [[AFHTTPRequestOperationManager alloc] initWithBaseURL:baseURL];
    
    NSOperationQueue *operationQueue = manager.operationQueue;
    
    [manager.reachabilityManager setReachabilityStatusChangeBlock:^(AFNetworkReachabilityStatus status) {
        switch (status) {
            case AFNetworkReachabilityStatusReachableViaWWAN:
            case AFNetworkReachabilityStatusReachableViaWiFi:
                [operationQueue setSuspended:NO];
                netState = YES;
                break;
            case AFNetworkReachabilityStatusNotReachable:
                netState = NO;
            default:
                [operationQueue setSuspended:YES];
                break;
        }
    }];
    
    [manager.reachabilityManager startMonitoring];
    
    return netState;
}

+ (void) NetRequestPOSTWithRequestURL: (NSString *) requestURLString
                        WithParameter: (NSDictionary *) parameter
                 WithReturnValeuBlock: (ReturnValueBlock) block
                   WithErrorCodeBlock: (ErrorCodeBlock) errorBlock
                     WithFailureBlock: (FailureBlock) failureBlock
{
    AFHTTPRequestOperationManager *manager = [[AFHTTPRequestOperationManager alloc] init];
    
    AFHTTPRequestOperation *op = [manager POST:requestURLString parameters:parameter success:^(AFHTTPRequestOperation *operation, id responseObject) {
//        NSDictionary *dic = [NSJSONSerialization JSONObjectWithData:responseObject options:NSJSONReadingAllowFragments error:nil];
        
//        DDLog(@"%@", dic);
        manager.responseSerializer.acceptableContentTypes = [NSSet setWithObjects:@"text/plain",@"application/json",@"text/html", nil];
        
        if ([[responseObject objectForKey:@"code"] intValue] == 0) {
              block(responseObject,[[responseObject objectForKey:@"code"] intValue]);
        }
        else {
            errorBlock(responseObject);
        }
      
        /***************************************
         在这做判断如果有dic里有errorCode
         调用errorBlock(dic)
         没有errorCode则调用block(dic
         ******************************/
        
    } failure:^(AFHTTPRequestOperation *operation, NSError *error) {
        failureBlock();
    }];
    
    op.responseSerializer = [AFHTTPResponseSerializer serializer];
    
    [op start];
    
}



//+ (void)requestWithMethod:(NSString *)method paramars:(NSDictionary *)paramars paramarsSite:(NSString *)site sucessBlock:(sucessBlock)sucessBlock failure:(void (^)(NSError *))failure
//{
//    
//    AFHTTPRequestOperationManager * manager = [AFHTTPRequestOperationManager manager];
//    manager.responseSerializer.acceptableContentTypes = [NSSet setWithObjects:@"text/plain",@"application/json",@"text/html", nil];
//    [manager.requestSerializer willChangeValueForKey:@"timeoutInterval"];
//    manager.requestSerializer.timeoutInterval = 10.f;
//    [manager.requestSerializer didChangeValueForKey:@"timeoutInterval"];
//    NSString *url = [NSString stringWithFormat:@"%@%@",method,site];
//    [manager POST:url parameters:paramars success:^(AFHTTPRequestOperation *operation, id responseObject) {
//        sucessBlock(responseObject,[[responseObject objectForKey:@"code"] intValue]);
//    } failure:^(AFHTTPRequestOperation *operation, NSError *error) {
//        NSLog(@"%@",[error localizedDescription]);
//    }];
//    
//    
//}

@end
