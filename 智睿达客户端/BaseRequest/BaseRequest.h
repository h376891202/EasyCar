//
//  BaseRequest.h
//  智睿达客户端
//
//  Created by tony1220 on 15/4/27.
//  Copyright (c) 2015年 tony1220. All rights reserved.
//

#import <Foundation/Foundation.h>

//typedef void(^sucessBlock) (id content,int statusCode);

@interface BaseRequest : NSObject

#pragma 监测网络的可链接性
+ (BOOL) netWorkReachability;

#pragma POST请求
+ (void) NetRequestPOSTWithRequestURL: (NSString *) requestURLString
                        WithParameter: (NSDictionary *) parameter
                 WithReturnValeuBlock: (ReturnValueBlock) block
                   WithErrorCodeBlock: (ErrorCodeBlock) errorBlock
                     WithFailureBlock: (FailureBlock) failureBlock;


//+ (void)requestWithMethod:(NSString *)method
//                 paramars:(NSDictionary *)paramars
//             paramarsSite:(NSString *)site
//              sucessBlock:(sucessBlock)sucessBlock
//                  failure:(void (^)(NSError * error))failure;

//+ (void)requestWithMethod:(NSString *)method
//                 paramars:(NSDictionary *)paramars
//             paramarsSite:(NSString *)site
//                dataImage:(NSData *)data
//              sucessBlock:(sucessBlock)sucessBlock
//                  failure:(void (^)(NSError * error))failure;


@end
